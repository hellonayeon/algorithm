class Q9654 {
    public static void main(String[] args) {
        String[][] fleet = {
            {"SHIP NAME",      "CLASS",          "DEPLOYMENT", "IN SERVICE"},
            {"N2 Bomber",      "Heavy Fighter",  "Limited",    "21"},        
            {"J-Type 327",     "Light Combat",   "Unlimited",  "1"},         
            {"NX Cruiser",     "Medium Fighter", "Limited",    "18"},        
            {"N1 Starfighter", "Medium Fighter", "Unlimited",  "25"},      
            {"Royal Cruiser",  "Light Combat",   "Limited",    "4"}   
        };
        
        for(int i=0; i<fleet.length; i++){
            System.out.println(String.format("%-15s%-15s%-11s%-10s", fleet[i][0], fleet[i][1], 
                                             fleet[i][2], fleet[i][3]));
        }
    }
}