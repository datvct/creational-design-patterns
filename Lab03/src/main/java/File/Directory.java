package File;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemComponent{
    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        children.add(component);
    }

    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public void showInfo() {
        System.out.println("📁 Directory: " + name);
        for (FileSystemComponent child : children) {
            child.showInfo();
        }
    }
}
