// Create a Project class that has the fields of name and description.
// Create an instance method called elevatorPitch that will return the name and description separated by a colon.
// Overload the constructor method in three different ways : public Project() {}, public Project(String name) {}, public Project(String name, String description) {}
// Add an additional initialCost member variable that is of type double and has both getters and setters
// Add this to the elevator pitch in parentheses after the name, e.g.: name (cost): description
// Portfolio class that will keep an ArrayList of Project in the field projects. Use generics to ensure these are Project objects.
// Add the appropriate getters/setters/constructors for this class to work
// Add the getPortfolioCost method that calculates and returns the cost to buy the entire portfolio.
// Add the showPortfolio method that will print all the project elevator pitches, followed by the total cost.

class Project{
    

    private String name;
    private String description;
    private double initialCost;


    public Project(String newName, String newDescription){

        this.name = newName;
        this.description = newDescription;
    }

    public Project(String newName){

        this.name = newName;

    }
    public Project(){

    }

    public String getName(){

        return this.name;
    } 

    public void getDescription(){

        System.out.println(this.description);
        
    }

    public double getCost(){

        return this.initialCost;
    } 

    public void setName(String newName){

        this.name = newName;
    }

    public void setDescription(String newDescription){

        this.description = newDescription;
    }

    public void setCost(double inputCost){

        this.initialCost = inputCost;
    }

    public String elevatorPitch(){

        String output = "Project name " + this.name + "("+this.initialCost+"): " + this.description;
        return output;
    }

    

}