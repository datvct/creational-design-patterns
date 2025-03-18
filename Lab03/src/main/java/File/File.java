package File;

public class File implements FileSystemComponent{
    private String name;
    private String content;

    public File(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public void showInfo() {
        System.out.println("📄 File: " + name + " - Content: " + content);
    }
}
