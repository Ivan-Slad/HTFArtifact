package htf.artifact.assignments.assignement1;

public class assignment1 {
    public static void main(String[] args) {
        SoapClient client = new SoapClient();
        System.out.println(client.getResponse().getPartialUnlockCode());
    }
}
