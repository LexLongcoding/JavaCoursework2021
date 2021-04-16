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