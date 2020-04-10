import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class MyAVLTree {
    private String outputString;
    private File file;
    private int fileLength;
    private AVLTree<LSData> at;

    public MyAVLTree(String FileName) throws IOException{

        this.file = new File(FileName);
        this.fileLength = fileLen(); 
        Scanner sc = new Scanner(file);
        this.at = new AVLTree<LSData> ();
        


        for (int i=0; i< fileLength; i ++){

            at.insert(new LSData(sc.nextLine()));
        }
        sc.close();
    }

    private int fileLen() throws IOException{
        int fileLeng = 0;

        BufferedReader br = new BufferedReader(new FileReader(this.file));
        while (br.readLine() != null) {
            fileLeng ++;
        }
        br.close();
        return fileLeng;
    }

    public void printAllAreas(){
        outputString = "";
        at.treeOrder();
        outputString = at.getOrderString();
    }

    public void printAreas(String stage, String day, String startTime){
        
        outputString = "";
        String check = new String (stage + "_"+day+"_"+startTime + " NA");


            BinaryTreeNode<LSData> x = (at.find(new LSData(check)));
            if (x==null){
                outputString = "";
                System.out.println("No zones found for:");
                outputString += "No zones found for:\n";
                System.out.println(stage + "_"+day+"_"+startTime);
                outputString += stage + "_"+day+"_"+startTime +"\n";
                System.out.println();
                System.out.println("Number of comparisons to insert: "+ "\n" + at.DiscreteCounterInsert);
                outputString += "Number of comparisons to insert: "+ "\n" + at.DiscreteCounterInsert +"\n";
                System.out.println("Number of comparisons to find: " + "\n" + at.DiscreteCounterFind);
                outputString += "Number of comparisons to find: " + "\n" + at.DiscreteCounterFind +"\n";
            }
            if (x != null){
                outputString = "";
                System.out.println("Zone(s) found for:");
                outputString += "Zone(s) found for:\n";
                System.out.println((x.data).toString());
                outputString += (x.data).toString() + "\n";
                System.out.println("Number of comparisons to insert:");
                outputString += "Number of comparisons to insert:" +"\n";
                System.out.println(at.DiscreteCounterInsert);
                outputString += (at.DiscreteCounterInsert) +"\n";
                System.out.println("Number of comparisons to find:");
                outputString += ("Number of comparisons to find:")+"\n";
                System.out.println(at.DiscreteCounterFind);
                outputString += (at.DiscreteCounterFind);
            }
        
            else
            {
                System.out.println("Invalid Arguments");
            }
    
    
    }  
    public String getOutPutString(){
        return this.outputString;
    }

}
