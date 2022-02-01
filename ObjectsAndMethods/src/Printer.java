public class Printer {
    private String queue = "";
    private int allAddedPages = 0;
    private int allPrintedPages = 0;

    public void append(String docText){
         queue += "Text: " + docText + "\n";
    }
    public void append(String docText,String docName){
        append(docText + " Document name: " + docName + "; " + "\n");
    }
    public void append(String docText,String docName,int docPageCount){
        append(docText + "; " + " Document name: " + docName + "; " + " Pages count: " + docPageCount  + "; "  + "\n");
        allAddedPages += docPageCount;
    }
    public void print(){
        if (queue.isEmpty()){
            System.out.println("No document for print!");
        }else{
            System.out.println(queue);
            allPrintedPages += allAddedPages;
            clear();
        }
    }
    public int getAllPrintedPages(){
        return allPrintedPages;
    }
    public int getPendingPagesCount(){
        return allAddedPages;
    }


    public void clear(){
        System.out.println("Queue was cleared!");
        queue = "";
    }


}
