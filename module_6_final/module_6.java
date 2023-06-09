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
            System.out.print(" | ID: " + names[k + counter][3]);
            System.out.print(" | Title: ");
            System.out.print(names[k + counter][0]);
            printSpace(space - names[k + counter][0].length());
            System.out.print(" Priority: ");
            System.out.print(names[k + counter][2] + " | ");
            System.out.print("\n");
            
        }
        Scanner view_input = new Scanner(System.in);
        String viewInputValue;
        System.out.println("\nHow would you like to view your task(s)?");
        System.out.println("\nNone (Press enter)");
        System.out.println("[0] View by priority");
        System.out.println("[1] Search");
        System.out.println("[2] View");
        System.out.print("\n#:");
        viewInputValue = view_input.nextLine();
        switch (viewInputValue) {
            case "0":
                System.out.println("view by priority func");
                prioritySearch(names, counter);
                break;
            case "1": 
                System.out.println("search func");
                searchArray(counter, names);
                break;
            case "2": 
                System.out.println("view");
                System.out.println(notNull);
                viewId(names, counter, notNull);
                break;
        }
       
    }

    public static void viewId(String[][] names, int counter, int notNull){
        Scanner input = new Scanner(System.in);
        int value = 0;
        System.out.print("Enter the ID of the task you would like to view: ");
        value = input.nextInt();
        System.out.println(value);
        editId(value, names);
        
    }

    public static void searchArray(int counter, String[][] names){
        Scanner input = new Scanner(System.in);
        String value;
        System.out.print("Please enter the name of the task you are searching for: ");
        value = input.nextLine();
        System.out.println(value + " search");
        boolean cont = true;
        int searchInt = names.length;
        int matchCount = 0;
        int noMatchCount = 0;
        int[] searchFound = new int[names.length];
        int searchFoundCounter = 0;
        for(int set = 0; set < searchFound.length; set++){
            searchFound[set] = searchFound.length + 1;
        }
        for(int j = 0; j < searchFound.length; j++){
            
            if(searchFound[j] < searchFound.length + 1){
                searchFoundCounter++;
            }
        }
        System.out.println(searchFoundCounter + " search found counter");
        while(cont){
            
            searchInt--;
            System.out.println(searchInt + " search");
            
            for(int search = 0; search < names.length; search++){
                if(names[search][0] != null){

                    
                    if(names[search][0].length() != value.length()){
                        System.out.println("none found 2");
                        cont = false;
                
                    }
                }
            }   



            if(names[searchInt][0].length() != value.length()){
                System.out.println("none found");
                cont = false;
            
            }
            
            
            if(names[searchInt][0].charAt(0) == value.charAt(0)){
                System.out.println("name found on counter " + searchInt);
                cont = false;
            }
            
            for(int i = 0; i < value.length(); i++){
                if(names[searchInt][0].charAt(i) == value.charAt(i)){
                    System.out.println("found match");
                    matchCount++;
                } else {
                    System.out.println("no match found");
                    noMatchCount++;
                }
            }
            if(matchCount > 2){
               searchFound[searchFoundCounter] = searchInt; 
            }
            if(searchInt <= 0){
                System.out.println("exiting loop");
                cont = false;
                
            }
            //for(int y: searchFound){
                //if(y < searchFound.length + 1){
                    //System.out.println(y + " searchfound");
                    //System.out.println(names[y][0]);
                //}
            //}
        }
        for(int test: searchFound){
            if(test < searchFound.length + 1){
                
            }
        }
        for(int j = 0; j < searchFound.length; j++){
            
            if(searchFound[j] < searchFound.length + 1){
                searchFoundCounter++;
            }
        }
        System.out.println("\n");
        for(int k = 0; k < searchFoundCounter; k++){
            if(k < searchFound.length + 1){
                int space = 10;
                System.out.print(searchFound[k]);
                System.out.print(" | Title: ");
                System.out.print(names[searchFound[k]][0]);
                printSpace(space - names[searchFound[k]][0].length());
                System.out.print(" Priority: ");
                System.out.print(names[searchFound[k]][2] + " | ");
                System.out.print("\n\n");
            }
        }
        System.out.println("\n");
    }



    public static void printSpace(int count){
        for(int i = 0; i < count; i++){
            System.out.print(" ");
        }
        System.out.print(" | ");
    }

    public static void prioritySearch(String[][] names, int counter){
        int notNull = 0;
        for(int i = 0; i < names.length; i++){
            if(names[i][0] != null){
                notNull++;
            }
        }
        Scanner input = new Scanner(System.in);
        String value;
        System.out.println("\nWhat priority would you like to view?");
        System.out.println("\nNone (Press enter)");
        System.out.println("[1] High");
        System.out.println("[2] Medium");
        System.out.println("[3] Low");
        System.out.print("\n#:");
        value = input.nextLine();
        switch (value) {
            case "1":
                prioritySearchPrinter(names, notNull, counter, '1');
                break;
            case "2":
                prioritySearchPrinter(names, notNull, counter, '2');
                break;
            case "3":
                prioritySearchPrinter(names, notNull, counter, '3');
                break;
        }
    }

    public static boolean checkForTitle(String[][] names, String search){
        int counter = 0;
        int possibleCounter = 0;
        int notNull = 0;
        String possible[] = new String[names.length];
        for(int i = 0; i < names.length; i++){
            if(names[i][0] == null){
                counter++;
            } else {
                notNull++;
            }

        }
        for(int i = 0; i < possible.length; i++){
            if(possible[i] == null){
                possibleCounter++;
            }
        }
        //System.out.println(names.length + " names length");
        //System.out.println(counter + " counter length");
        //System.out.println(possibleCounter + " poss counter");
        //System.out.println(notNull + " not null");
        if(counter == names.length){
            //System.out.println("return true 0");
            return true;
        } else {
            int noLength = 0;
            //System.out.println("return false 0");
            //loop through all of names find possible names and putting them in the possible array
            for(int i = 0; i < names.length; i++){
                if(names[i][0] != null){
                    if(names[i][0].charAt(0) == search.charAt(0)){
                        //System.out.println("charat found");
                        int match = 0;
                        int noMatch = 0;
                        boolean cont = true;
                        possible[possibleCounter - 1] = names[i][0];
                        while(cont){
                            for(int j = 0; j < names.length; j++){
                                if(names[j][0] != null){
                                    for(int y = 0; y < search.length(); y++){
                                       
                                        if(search.length() > names[j][0].length()){
                                            System.out.println("custom return true 1");
                                            return true;
                                        
                                        }
                                        if(names[j][0].charAt(y) == search.charAt(y)){
                                            match++;

                                            System.out.println(match + " match found");
                                            cont = false;
                                        } else {
                                            noMatch++;
                                            System.out.println(noMatch + " no match found");
                                            cont = false;
                                        }
                                    }
                                }
                            }
                            if(match >= search.length()){
                                System.out.println(match + " match count");
                                System.out.println(noMatch + " noMatch count");
                                //System.out.println("match exists");
        
                                errorReturn("name is already taken");
                                mainMenu(true, names);
                            }
                        }
                    }
                }
            }
            for(String j: possible){
                if(j != null){
                    System.out.println(j + " poss array");
                }
            }
        }
        return true;
    }
        
    
    public static void create(String[][] names){
        Scanner input = new Scanner(System.in);
        String value = null;
        int counter = 0;
        int newCount = 0;
        System.out.print("Enter the name of the new task: ");
        
        value = input.nextLine();
        if(value == ""){
            errorReturn("Invalid name");
            mainMenu(false, names);
        }
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

        System.out.println(checkForTitle(names, value));
        if(checkForTitle(names, value)){
            System.out.println(counter - 1 + " set here");
            names[counter - 1][0] = value;
            names[counter - 1][3] = counter - 1 + "";
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


        int priority;
        System.out.println("What is the priority of this task: \n");
        System.out.println("[1] High");
        System.out.println("[2] Medium");
        System.out.println("[3] Low");
        System.out.println("[4] No Priority \n");
        System.out.print("#: ");
        priority = input.nextInt();
        if(priority > 4){
            errorReturn("not an option task priority not set!");
        } else {
            priority(names, counter, priority);
        }

        



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
        int value = 0;
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
            System.out.print(" | ID: " + names[k + counter][3]);
            System.out.print(" | Title: ");
            System.out.print(names[k + counter][0]);
            printSpace(space - names[k + counter][0].length());
            System.out.print("\n");
            
        }
        System.out.print("Enter the ID of the task you would like to edit: ");
        value = input.nextInt();
        for(int id = 0; id < names.length; id++){
            if(id == value){
                editId(id, names);
            }
        }

    }
    public static void editId(int editid, String[][] names){
        String value;
        Scanner input = new Scanner(System.in);
        System.out.println("\nWhat would you like to edit?");
        System.out.println("None (Press enter)");
        System.out.println("[1] name");
        System.out.println("[2] notes");
        System.out.println("[3] priority");
        System.out.print("\n#:");
        value = input.nextLine();
        switch(value){
            case "1":
                System.out.println("name");
                editPrint(names, editid, 1);
                break;
            case "2":
                System.out.println("notes");
                editPrint(names, editid, 2);
                break;
            case "3":
                System.out.println("prio");
                editPrint(names, editid, 3);
                break;
        }
    }

    public static void editPrint(String[][] names, int editid, int type){
        //System.out.println(names[editid][type - 1]);

        switch(type){
            case 1:

                System.out.println("Current: \n" + names[editid][type - 1]);
                nameChange(names, editid);
                break;
            case 2:
                System.out.println("Current: \n" + names[editid][type - 1]);
                break;
            case 3: 
                System.out.println("Current: \n" + names[editid][type - 1]);
        }
    }

    public static void nameChange(String[][] names, int editId){
        String newName;
        Scanner input = new Scanner(System.in);
        boolean cont = true;
        while(cont){
            System.out.println(editId);
            System.out.println(names[editId][0]);
            System.out.print("What would you like to rename this task?: ");
            newName = input.nextLine();
            if(newName == ""){
                errorReturn("Invalid name");
                nameChange(names, editId);
            }
            if(newName.length() >= 16){
                errorReturn("Name is too long");
                nameChange(names, editId);

            }
            if(newName.charAt(0) == '.'){
                errorReturn("Invalid name");
                nameChange(names, editId);
            }
            int emptyCount = 0;
            for(int i = 0; i < newName.length(); i++){
                if(newName.charAt(i) == ' '){
                    emptyCount++;
                }
            }
            if(emptyCount > 0){
                errorReturn("Invalid name");
                nameChange(names, editId);
            }
            System.out.println(editId);
            if(checkForTitleRename(names, newName, editId) == false){
                errorReturn("Name already taken");
                cont = false;
                nameChange(names, editId);
            } else {
                names[editId][0] = newName;
            }
        }

              

    }

    public static boolean checkForTitleRename(String[][] names, String search, int exclude){
        boolean cont = true;
        int whileCount = 0;
        String[][] searchArray = new String[1][1];
        searchArray[0][0] = search;
        boolean found = false;
        int foundCount = 0;
        int notFoundCount = 0;
        for(int i = 0; i < names.length; i++){
            if(names[i][0] != null){
                for(int k = 0; k < searchArray[0][0].length(); k++){
                    System.out.println(i);
                    if(i == exclude){
                        i += 1;
                    }
                    if(names[i - 1][0].charAt(k) == searchArray[0][0].charAt(k)){
                        System.out.println("char found");
                        foundCount++;
                    } else {
                        System.out.println(" no char found");
                        notFoundCount++;
                    }
                    if(foundCount >= searchArray[0][0].length()){
                        System.out.println(foundCount + "\n" + notFoundCount);
                        System.out.println("return false here");
                        return false;
                    } else {
                        System.out.println(foundCount + "\n" + notFoundCount);
                        System.out.println("return true here");
                        return true;
                    }
                }
            }
        }
        return true;
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
        if(value > 3){
            errorReturn("not found");
            mainMenu(false, names);
        }

      

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
        if(listCount == 0 || listCount < 1){
            errorReturn("you must have more than 1 task!");
            System.exit(0);
        }
        String[][] table = new String[listCount][4];
        return table;

    }

    public static void prioritySearchPrinter(String[][] names, int notNull, int counter, char prioNumber){
        for(int one = 0; one < notNull; one++){
            int newCount = counter - 1;
            int space = 10;
            if(names[one + counter][2].charAt(1) == prioNumber){
                System.out.print(one + 1);
                System.out.print(" | Title: ");
                System.out.print(names[one + counter][0]);
                printSpace(space - names[one + counter][0].length());
                System.out.print(" Priority: ");
                System.out.print(names[one + counter][2] + " | ");
                System.out.print("\n");
            }
                    //System.out.println(names[one + counter][2] + " | ");
        }
    }

    public static void priority(String[][] names, int counter, int input){
        int counterPrint = counter - 1;
        switch(input){
            case 1:
                System.out.println("priority has been set to high on task: " + counterPrint);
                names[counter - 1][2] = "[1]";
                break;
            case 2: 
                System.out.println("priority has been set to Medium on task: " + counterPrint);
                names[counter - 1][2] = "[2]";
                break;
            case 3: 
                System.out.println("priority has been set to Low on task: " + counterPrint);
                names[counter - 1][2] = "[3]";
                break;
            case 4:
                System.out.println("priority has been set to No Priority on task: " + counterPrint);
                names[counter - 1][2] = "[4]";
                break;
        }
    }

    public static void main(String arg[]){
        Scanner input = new Scanner(System.in);
        
        String[][] table = start();

        printTitle("To Do List", true);
        mainMenu(true, table);

        
        

    }
}