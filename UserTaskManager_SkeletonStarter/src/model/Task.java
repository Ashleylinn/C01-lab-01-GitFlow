package model;

public class Task {
    private String title;
    private String description;
    private boolean done;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.done = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void markDone() {
    	this.done = true;
    }

    @Override
    public String toString() {
        return title + ": " + description;
    }
}
