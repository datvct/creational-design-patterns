package File;

public class Test {
    public static void main(String[] args) {
        Directory root = new Directory("Root");
        Directory documents = new Directory("Documents");
        Directory images = new Directory("Images");

        File file1 = new File("resume.pdf", "My Resume");
        File file2 = new File("photo.jpg", "Vacation Photo");

        documents.add(file1);
        images.add(file2);

        root.add(documents);
        root.add(images);

        root.showInfo();
    }
}
