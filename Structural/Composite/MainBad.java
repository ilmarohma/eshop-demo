package Composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class File {
    int size;
    public File(int size) { this.size = size; }
    public int getSize() { return size; }
}

class Folder {
    
    List<File> files = new ArrayList<>();
    List<Folder> subFolders = new ArrayList<>();

    public Folder(List<File> files, List<Folder> subFolders) {
        this.files = files;
        this.subFolders = subFolders;
    }

    public void addFile(File f) { files.add(f); }
    public void addFolder(Folder f) { subFolders.add(f); }

    public int calculateTotalSize() {
        int total = 0;
        for (File f : files) {
            total += f.getSize();
        }
        for (Folder f : subFolders) {
            total += f.calculateTotalSize();
        }
        return total;
    }
}

public class MainBad{
    public static void main(String[] args) {
        Folder folder = new Folder(Arrays.asList(new File(12), new File(35)), 
                                   Arrays.asList(new Folder(Arrays.asList(new File(10), new File(30), new File(20)), 
                                                            Collections.emptyList())));

        System.out.println(folder.calculateTotalSize());
    }
}