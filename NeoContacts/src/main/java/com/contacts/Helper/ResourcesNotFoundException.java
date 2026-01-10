package com.contacts.Helper;

public class ResourcesNotFoundException extends RuntimeException {
    public ResourcesNotFoundException() {
        super("Requested Resource Not Found");
    }

    public ResourcesNotFoundException(String message) {
        super(message);
    }

}
