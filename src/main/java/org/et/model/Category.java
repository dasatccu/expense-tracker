package org.et.model;

import org.et.util.LogService;

public class Category {
    private String name;
    private String description;
    private CategoryType type; // INCOME or EXPENSE

    private static final String TAG = "Category";

    public Category(String name, String description, CategoryType type) {
        this.name = name;
        this.description = description;
        this.type = type;
        LogService.info(TAG, "Created new category: " + this.toString());
    }

    public String getName() {
        LogService.debug(TAG, "Getting name: " + name);
        return name;
    }

    public void setName(String name) {
        LogService.info(TAG, "Changing name from " + this.name + " to " + name);
        this.name = name;
    }

    public String getDescription() {
        LogService.debug(TAG, "Getting description: " + description);
        return description;
    }

    public void setDescription(String description) {
        LogService.info(TAG, "Changing description from " + this.description + " to " + description);
        this.description = description;
    }

    public CategoryType getType() {
        LogService.debug(TAG, "Getting type: " + type);
        return type;
    }

    public void setType(CategoryType type) {
        LogService.info(TAG, "Changing type from " + this.type + " to " + type);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
    }
}
