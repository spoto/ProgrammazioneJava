package it.univr.file;

import java.io.FileNotFoundException;

public class MainFiles {

	public static void main(String[] args) throws FileNotFoundException {
		Component f1 = new FileComponent("cat1.jpg", 34590);
		Component f2 = new FileComponent("dog.gif", 12422);
		Component f3 = new FileComponent("cat2.jpg", 52402);
		Component images = new DirectoryComponent("images", f1, f2, f3);
		Component music = new DirectoryComponent("music"); // directory vuota
		Component f4 = new FileComponent("Pippo.java", 3255);
		Component f5 = new FileComponent("Paperino.c", 44341);
		Component work = new DirectoryComponent("work", f4, f5);
		Component f6 = new FileComponent("passwords.txt", 3233);
		Component root = new DirectoryComponent("root", work, images, f6, music);
		System.out.println(root);
		System.out.println();
		System.out.println("total size: " + root.size() + " bytes");
		System.out.println("files: " + root.getFiles());
		System.out.println("dog.gif si trova come " + root.find("dog.gif"));
		System.out.println("Pluto.c si trova come " + root.find("Pluto.c"));
	}
}