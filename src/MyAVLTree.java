import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

/**
 * A Class which creates a MyAVLTree object which will store data from a text file in an AVL tree.
 * The Tree will load in LSData Objects as arguments and will perform methods to search for Datapoints
 * 
 * @author Alaric McGregor
 */

public class MyAVLTree {
    private String outputString;
    private File file;
    private int fileLength;
    private AVLTree<LSData> at;

    /**
     * Constructor which will create the MyAVLTree object which will load in data from a text file.
     * 
     * @param FileName Name of the File from which data is loaded. eg. "Data.txt"
     * @throws IOException throws an exception if the File is not found.
     */
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
    /**
     * Method to find the length of the file which the MyAVLTree is using
     * 
     * @return an int which is the length of the file 
     * @throws IOException throws an exception if there is no file or the buffered reader doesn't work
     */
    private int fileLen() throws IOException{
        int fileLeng = 0;

        BufferedReader br = new BufferedReader(new FileReader(this.file));
        while (br.readLine() != null) {
            fileLeng ++;
        }
        br.close();
        return fileLeng;
    }
    /**
     * traverses through the AVL Tree and prints all the Data Nodes in left to right order.
     */

    public void printAllAreas(){
        outputString = "";
        at.treeOrder();
        System.out.print("\033[H\033[2J");
        outputString = at.getOrderString();
    }
    /**
     * takes an argument which forms a key and finds an object in the AVL Tree with that same key.
     * It will then print out the number of comparisons used to find and insert aswell as if the zone was found 
     * and what zone was found.
     * 
     * @param stage This forms part of the key and is the Stage of the load shedding
     * @param day This forms part of the key and is the day of the load shedding
     * @param startTime This forms part of the key and is the starting time of the load shedding
     */
    public void printAreas(String stage, String day, String startTime){
        
        outputString = "";
        String check = new String (stage + "_"+day+"_"+startTime + " NA");


            BinaryTreeNode<LSData> x = (at.find(new LSData(check)));
            if (x==null){
                outputString = "";
                //System.out.println("No zones found for:");
                outputString += "No zones found for:\n";
                //System.out.println(stage + "_"+day+"_"+startTime);
                outputString += stage + "_"+day+"_"+startTime +"\n";
                //System.out.println();
                //System.out.println("Number of comparisons to insert: "+ "\n" + at.DiscreteCounterInsert);
                outputString += "Number of comparisons to insert: "+ "\n" + at.DiscreteCounterInsert +"\n";
                //System.out.println("Number of comparisons to find: " + "\n" + at.DiscreteCounterFind);
                outputString += "Number of comparisons to find: " + "\n" + at.DiscreteCounterFind +"\n";
            }
            if (x != null){
                outputString = "";
                //System.out.println("Zone(s) found for:");
                outputString += "Zone(s) found for:\n";
                //System.out.println((x.data).toString());
                outputString += (x.data).toString() + "\n";
                //System.out.println("Number of comparisons to insert:");
                outputString += "Number of comparisons to insert:" +"\n";
                //System.out.println(at.DiscreteCounterInsert);
                outputString += (at.DiscreteCounterInsert) +"\n";
                //System.out.println("Number of comparisons to find:");
                outputString += ("Number of comparisons to find:")+"\n";
                //System.out.println(at.DiscreteCounterFind);
                outputString += (at.DiscreteCounterFind);
            }
        
           // else
            //{
                //System.out.println("Invalid Arguments");
           // }
    
    
    }  
    /**Gets the String from the printAreas or PrintAllAreas and returns it 
     * 
     * @return String representation of the output from the PrintAllAreas or PrintAreas method.
     */
    public String getOutPutString(){
        return this.outputString;
    }

}
