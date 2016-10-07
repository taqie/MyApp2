package pl.edu.pwr.s210428.myapp2;

/**
 * Created by android on 07.10.16.
 */




public class Player {
    public boolean active;
    protected String name;
    protected String znak;
    protected int val;
    public Player(String name, String znak, boolean active, int val){
        this.name=name;
        this.znak=znak;
        this.active=active;
        this.val=val;
    }

}
