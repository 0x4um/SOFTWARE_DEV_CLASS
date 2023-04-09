import java.util.Scanner;
class module_6{

    public static void errorReturn(String errorMessage){
        System.out.println("\nERROR: " + errorMessage);
    }

    public static void list(String[][] names){
        printTitle("Notes", false);
        int counter = 0;
        int notNull = 0;
        for(int i = 0; i < names.length; i++ ){
            if(names[i][0] == null){
                counter++;
            }
            if(names[i][0] != null){
                notNull++;
            }
        }
        if(counter <= names.length - 1){
            if(notNull == 1){
                
                System.out.println("(You have " + notNull + " task)");

            } else {
                
                System.out.println("(You have " + notNull + " tasks)");
            }
        } else {
            errorReturn("You have no tasks");
            mainMenu(false, names);
        }
        
        for(int k = 0; k < notNull; k++){
            int newCount = counter - 1;
            int space = 10;
            System.out.print(k + 1);
            System.out.print(" | Title: ");
            System.out.print(names[k + counter][0]);
            printSpace(space - names[k + counter][0].length());
            
        }
        
    }

    public static void printSpace(int count){
        for(int i = 0; i < count; i++){
            System.out.print(" ");
        }
        System.out.print(" |\n");
    }

    public static boolean checkForTitle(String[][] names, String search){
        String[] possible = new String[names.length];
        String[] starters = new String[names.length];
        int notNull = 0;
        int counter = 0;
        int matchCount = 0;
        int noMatchCount = 0;
        boolean found;
        for(int y = 0; y < names.length; y++){
            if(names[y][0] == null){
                counter++;
            } else {
                notNull++;
            }
        }
        System.out.println(notNull + " not null count");
        if(notNull >= 1){
            for(int i = 0; i < notNull; i++){
                if(names[i + counter][0].charAt(0) == search.charAt(0)){
                    starters[i] = names[i + counter][0];
                    for(String y : starters){
                        if(y != null){
                            for(String k : starters){
                                if(k != null){

                                
                                    for(int u = 0; u < k.length(); u++){
                                        if(k.charAt(u) == search.charAt(u)){
                                            matchCount++;
                                        } else {
                                            noMatchCount++;
                                        }
                                    
                                    }
                                }
                                System.out.println(matchCount + " Match Count");
                                System.out.println(noMatchCount + " No Match Count");

                        }
                    }
                } 
               
                
            }
        }
        } else {
            System.out.print("CUSTOM TRUE 9");
            return true;
        }
        
        
        for(String j : starters){
            if(j != null){
                System.out.println(j + " (counter) ");
            }
        }
        int startersCount = 0;
        for(int l = 0; l < starters.length; l++){
            if(starters[l] != null){
                startersCount++;
            }
        }
        if(noMatchCount < search.length()){
            System.out.println("CUSTOM TRUE RETURN ID 2");
            return true;
        } else {
            System.out.println("CUSTOM FALSE ID 1");
            return false;
        }
        
    }
    
    public static void create(String[][] names){
        Scanner input = new Scanner(System.in);
        String value;
        int counter = 0;
        int newCount = 0;
        System.out.print("Enter the name of the new task: ");
        
        value = input.nextLine();
       

        for(int k = 0; k < names.length; k++){
            if(names[k][0] != null){
                newCount++;
            }
        }
        

        if(value.length() >= 16){
            errorReturn("Name is too long");
            mainMenu(false, names);
        }

        if(value.charAt(0) == '.'){
            errorReturn("Invalid name");
            mainMenu(false, names);
        }
        int emptyCount = 0;

        for(int i = 0; i < value.length(); i++){
            if(value.charAt(i) == ' '){
                emptyCount++;
            }
        }
        //System.out.println(value.charAt(emptyCount));
        if(emptyCount > 0){
            errorReturn("Invalid name");
            mainMenu(false, names);
        }
        




        for(int i = 0; i < names.length; i++){
            if(names[i][0] == null){
                
                counter++;
            }
            
        }
        

        //names[counter - 1][0] = value;
        int counterPrint = counter - 1;

        if(checkForTitle(names, value) == true){
            System.out.println("no duplicates found all clear");
            names[counter - 1][0] = value;
        } else {
            System.out.println("name is in use");
            errorReturn("name is already in use");
            mainMenu(false, names);

        }
        //System.out.println(value + " has been set as counter " + counterPrint);
        //checkForTitle(names, counterPrint + "");
        
        printTitle("Text Editor", false);
        System.out.print("\n-------------------------------------------\n");
        System.out.print("You have 9 lines for notes use '|' to stop \n");
        System.out.print("Enter task information or notes here: \n");
        System.out.print("-------------------------------------------\n");
        
        String[] lineReader = new String[10];
        //System.out.print("\n\\\\ ");
        boolean cont = true;
        int length;
        while(cont == true){
            //System.out.print("\n\\\\ ");
            
            
            for(int i = 0; i < lineReader.length; i++){
                boolean printAgain = true;
                System.out.print(i + "| ~ ");
                //System.out.println("id" + i);
                
                lineReader[i] = input.nextLine();
                length = lineReader[i].length();
                
                //System.out.print(i);
                
                if(lineReader[i].length() >= 1){
                    char end = '|';
                    if(lineReader[i].charAt(length - 1) == end){
                        printAgain = false;
                        System.out.print("-------------------------------------------\n");
                        System.out.print("closing note... \n\n");
                        i = 9;
                        cont = false;
                    }
                }

                if(i > 8 && printAgain == true){
                    System.out.print("-------------------------------------------\n");
                    System.out.print("closing note... \n\n");
                    cont = false;
                }
                
            }
        }
        // i will now conver the lineReader[] array to one long string and put it intet the names[][] array
        //for(String d: lineReader){
            //System.out.println(d);
        //}
        int linesCounter = 0;
        for(int i = 0; i < lineReader.length; i++){
            if(lineReader[i] == ""){
                linesCounter++;
            }
            if(lineReader[i] == null){
                lineReader[i] = "";
            }
            
        }
        String insert;
        if(linesCounter < 10){
            insert = "" + lineReader[0] + "\n" + "" + lineReader[1] + "\n" + "" + lineReader[2] + "\n" + "" + lineReader[3] + "\n" + "" + lineReader[4] + "\n" + "" + lineReader[5] + "\n" + "" + lineReader[6] + "\n" + "" + lineReader[7] + "\n" + "" + lineReader[8] + "\n" + "" + lineReader[9] + "\n";
        } else {
            insert = "no notes recieved";
        }
        names[counter - 1][1] = insert;
        //System.out.print("\n\n" + names[counter - 1][1] + " (names array)");
        

        //System.out.println(names[counter - 1][0]);
        //System.out.println(names[counter - 1][1]);

        //System.out.println(names[counter - 1][1]);
        //int mutCounter = (counter -= counter);
        //System.out.println(mutCounter);
        //names[1][0] = value;
        
    }

    public static void edit(String[][] names){
        Scanner input = new Scanner(System.in);
        int counter = 0;
        int notNull = 0;
        String value;
        for(int i = 0; i < names.length; i++){
            if(names[i][0] != null){
                notNull++;
            }
            if(names[i][0] == null){
                counter++;
            }
        }
        if(notNull <= 0){
            errorReturn("You have no tasks");
        }
        for(int k = 0; k < notNull; k++){
            int newCount = counter - 1;
            int space = 10;
            System.out.print(k + 1);
            System.out.print(" | Title: ");
            System.out.print(names[k + counter][0]);
            printSpace(space - names[k + counter][0].length());
            
        }
        System.out.print("Enter the name of the task you would like to edit: ");
        value = input.nextLine();

        int validCount = 0;
        int invalidCount = 0;

        for(int j = 0; j < notNull; j++){
            String compare = names[counter - j][0];
            
            if(value.length() == compare.length()){
                
                for(int l = 0; l < compare.length(); l++){
                    if(compare.charAt(l) == value.charAt(l)){
                        
                        validCount++;
                    } else {
                        
                        invalidCount++;
                    }
                }
                //System.out.print(validCount);
                //System.out.print(invalidCount);
                if(validCount >= compare.length()){
                    System.out.print(j);
                    System.out.print("this name is valid and can be edited");
                } else {
                    errorReturn("This name does not exist");
                }
            } else {
                errorReturn("This name does not exist");
            }
        }

    }

    public static void execute(int number, String[][] names){
        switch (number){
            case 0:
                create(names);
                break;
            case 1:
                edit(names);
                break;
            case 2:
                list(names);
                break;
            case 3:
                break;
        }
    }

    public static void mainMenu(boolean first, String[][] names){
        Scanner input = new Scanner(System.in);
        int value;
        if(first){
            System.out.println("what would you like to do?");
        }
        System.out.println("\n[0]> add a new task");
        System.out.println("[1]> edit a task");
        System.out.println("[2]> list tasks");
        System.out.println("[3]> delete task");

        System.out.print("\n#: ");
        value = input.nextInt();

      

        execute(value, names);
        mainMenu(false, names);
        
    }

    

    public static void printTitle(String title, boolean large){
        int titleLength = title.length();
        for(int i = 0; i < titleLength + 18; i++){
            System.out.print("-");
        }
        if(large){
            System.out.print("\n|                          |");

        }
        System.out.print("\n|        " + title + "        |");
        if(large) {
            System.out.print("\n|                          |");

        }

        System.out.println();
        for(int i = 0; i < titleLength + 18; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static String[][] start(){
        int listCount; 
        Scanner input = new Scanner(System.in);
        printTitle("Welcome", false);
        System.out.println("How much tasks do you have?");
        System.out.print("Please enter a number here: ");
        
        listCount = input.nextInt();
        String[][] table = new String[listCount][4];
        return table;

    }

    public static void main(String arg[]){
        Scanner input = new Scanner(System.in);
        
        String[][] table = start();

        printTitle("To Do List", true);
        mainMenu(true, table);

        
        

    }
}