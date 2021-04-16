import java.util.*;

class Portfolio {

    private ArrayList<Project> projects;

    public Portfolio() {
    }

    public Portfolio(ArrayList<Project> newProject) {

        this.projects = newProject;
    }

    public ArrayList<String> getProjects() {

        ArrayList<String> ProjectName = new ArrayList<String>();
        for (int i = 0; i < this.projects.size(); i++) {

            ProjectName.add(projects.get(i).getName());

        }

        return ProjectName;

    }

    public void setProjects(ArrayList<Project> newProject) {

        this.projects = newProject;

    }

    public double getPortfolioCost() {

        double sum = 0;
        for (int i = 0; i < this.projects.size(); i++) {
            sum += projects.get(i).getCost();
        }
        return sum;
    }

    public void displayPortfolio(){

        double sum = 0;
        for(int i = 0; i < this.projects.size(); i++){
            System.out.println(this.projects.get(i).elevatorPitch());
            sum += projects.get(i).getCost();

        }

        System.out.println("Total : " + sum);


    }
}
