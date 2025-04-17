import java.util.Scanner;

public class Controller {

    public static boolean check(int[] arr, int i){

        for(int j: arr)
        {
            if (i == j)
            {
                return true;
            }
           
        }
        return false;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numer from 0...3 for a particular action");
        System.out.println("For adding node in the begining, enter 1");
        System.out.println("For adding node in the end, enter 2");
        System.out.println("For insert node at an index, enter 3");
        System.out.println("To update the head value, enter 4");
        System.out.println("To update the tail value, enter 5");
        System.out.println("To search in the linked list, enter 6");
        System.out.println("To use bubble sort, enter 7");
        System.out.println("To use merge sort, enter 8");
        System.out.println("To perform binary search, enter 9");
        System.out.println("To check if a cycle exists, enter 10");
        System.out.print("To quit, enter 0: ");

        
        LinkedList llst = new LinkedList();

        while(true)
        {

            System.out.println("Enter the numer from 0...3 for a particular action");
            System.out.println("For adding node in the begining, enter 1");
            System.out.println("For adding node in the end, enter 2");
            System.out.println("For insert node at an index, enter 3");
            System.out.println("To update the head value, enter 4");
            System.out.println("To update the tail value, enter 5");
            System.out.println("To search in the linked list, enter 6");
            System.out.println("To use bubble sort, enter 7");
            System.out.println("To use merge sort, enter 8");
            System.out.println("To perform binary search, enter 9");
            System.out.println("Enter 10 to check if any cycle exists");
            System.out.print("To quit, enter 0: ");

            int input = sc.nextInt();

            int[] options = {0,1,2,3,4,5,6,7,8,9, 10};
            Boolean present;
            present = check(options, input);
            if  (!present){
                System.out.println("The input is wrong, please select from integer options {1,2,3,4,5,6,7,8,9,10,0}");
            }

            else {



                switch (input) {
                    case 1:
                        System.out.print("Enter the number:");
                        int value =  sc.nextInt();
                        llst.addHead(value);
                        llst.display();
                        break;
                    case 2:
                        System.out.print("Enter the number:");
                        value =  sc.nextInt();
                        llst.addTail(value);
                        llst.display();
                        break;
                    case 3:
                        System.out.print("Enter the string:");
                        value = sc.nextInt();
                        System.out.print("Enter the index (In integer):");
                        int index = sc.nextInt();

                        if ((index <=-1) || (index > llst.Length())){
                            System.out.println("Index is out of bound!");
                            break;

                        }

                        else{
                            llst.addAtIndex(value, index);
                            System.out.println("Data has been added at "+ index);
                            llst.display();
                        }

                            break;
                    
                    case 4:
                            System.out.print("Enter the string:");
                            int newData = sc.nextInt();
                            llst.updateHead(newData);
                            llst.display();

                            break;
                    
                    case 5:
                            System.out.print("Enter the string:");
                            int ndata = sc.nextInt();
                            llst.updateTail(ndata);
                            llst.display();
                            break;

                    case 6:

                            System.out.print("Enter the string:");
                            int searchTarget = sc.nextInt();
                            //boolean outcome = llst.searchList(searchTarget);
                            //System.out.println(outcome);
                            //String result = outcome?searchTarget+" has been found in the linkedlist":searchTarget+" has NOT been found in the linkedlist";
                            //System.out.println(result);
                            System.out.println("We were looking for "+ searchTarget + " in: ");
                            llst.display();

                            break;
                    case 7:
                            llst.bubbleSort();
                            llst.display();
                            break;

                    case 8: 
                            llst.head = llst.mergeSort(llst.head);
                            llst.display();
                            break;
                    case 9:
                           System.out.print("Enter the number you want to search: ");
                           int target = sc.nextInt();
                           boolean found = llst.binarySearch(llst.head, target);
                           String result = found ? "The "+ target + " has been found in the linked list" : "The "+ target + " has NOT been found in the linked list";
                           System.out.println(result);
                           break;
                    
                    case 11:
                           System.out.println("Enter the index where you want to create the cycle");
                           int cycle = sc.nextInt();
                           llst.makeCycle(cycle);
                           llst.display();

                    case 10:
                           System.out.println("Enter the index where you want to check the existence the cycle");
                           int checkcycle = sc.nextInt();
                           boolean exists = llst.checkCycle(checkcycle);
                           System.out.println(exists?"The cycle exists at:" + checkcycle + " index":"The cycle doesn't exists");

                         
                           
                           





                    case 0:
                         llst.display();
                         sc.close();
                        System.out.println("Good Bye!");
                        return;

                    default:
                        break;
                }
            }

        }


    }
}







