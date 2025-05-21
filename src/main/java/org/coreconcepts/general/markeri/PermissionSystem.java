package org.coreconcepts.general.markeri;

// Marker interfaces for permissions
interface AdminAccess {}
interface ReadOnlyAccess {}

class User {
    private String name;
    private boolean isAdmin;

    public User(String name, boolean isAdmin) {
        this.name = name;
        this.isAdmin = isAdmin;
    }

    public Object getAccessController() {
        if (isAdmin) {
            return new AdminController();
        } else {
            return new UserController();
        }
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}

class AdminController implements AdminAccess {
    // Admin functionality
}

class UserController implements ReadOnlyAccess {
    // Limited functionality
}

public class PermissionSystem {
    public static void main(String[] args) {
        User adminUser = new User("Admin", true);
        User regularUser = new User("Regular", false);

        Object adminController = adminUser.getAccessController();
        Object userController = regularUser.getAccessController();

        // Check permissions using instanceof
        if (adminController instanceof AdminAccess) {
            System.out.println("Admin access granted");
            performAdminOperation();
        }

        if (userController instanceof ReadOnlyAccess) {
            System.out.println("Read-only access granted");
            performReadOperation();
        }
    }

    private static void performAdminOperation() {
        // Admin-only operations
    }

    private static void performReadOperation() {
        // Read-only operations
    }
}

