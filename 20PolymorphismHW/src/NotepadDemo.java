
public class NotepadDemo {
	public static void main(String[] args) {
		Page p1 = new Page("Title 1", "Text 1");
		Page p2 = new Page("Title 2", "Text 2");
		Page p3 = new Page("Title 3", "Text 3");
		Page p4 = new Page("Title 4", "Text 4");
		Page p5 = new Page("Title 5", "Text 5");
		
		Page[] somePages = {p1, p2, p3, p4, p5};
		
//		SimpleNotepad prostaTetradka = new SimpleNotepad(somePages, 40);
		
//		prostaTetradka.addTextToPageNumber("asda313", 4);
//		prostaTetradka.deleteTextAndAddNewTextToPageNumber("zdr hey hey1 ko staA?", 3);
//		prostaTetradka.deleteTextFromPageNumber(2);
//		prostaTetradka.previewAllPages();
		
//		p3.searchWord("staa");
//		p3.containsDigits();
//		prostaTetradka.searchWord("zdR");
//		p5.deleteText();
//		prostaTetradka.printAllPagesWithDigits();
		
//		SecuredNotepad slojnaTetradka = new SecuredNotepad(somePages, 30);
//		slojnaTetradka.addTextToPageNumber("ko staa brat", 2);
//		slojnaTetradka.deleteTextAndAddNewTextToPageNumber("smqtai", 1);
//		slojnaTetradka.deleteTextFromPageNumber(4);
//		slojnaTetradka.previewAllPages();
		
		ElectronicSecuredNotepad mnogoSlojnaTetradka = new ElectronicSecuredNotepad(somePages, 20);
		mnogoSlojnaTetradka.start();
		mnogoSlojnaTetradka.deleteTextFromPageNumber(3);
		mnogoSlojnaTetradka.previewAllPages();
	}
}
