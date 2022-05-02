public class arraySet {

    private String[] sex;
    private String[] nationality;
    private String[] person;
    private double[] weight;
    private int[] age;
    private double[] height;
    private String[] blood;

    private int mCount = 0;
    private int fCount = 0;

    int[] natArray;
    int poss;
    int times;

    public arraySet(int size){
        Names names = new Names();

        this.sex = new String[size];
        this.nationality = new String[size];
        this.weight = new double[size];
        this.person = new String[size];
        this.age = new int[size];
        this.height = new double[size];
        this.blood = new String[size];

        String[] name = new String[0];
        String[] nat = new String[0];
        String[] surname = new String[0];
        double rheight = 0;
        String[] bloodType = new String[0];

        natArray = new int[size];

        nat = names.getNationality();
        surname = names.getSurnames();
        bloodType = names.getBlood();

        for (int i = 0; i < size; i++){
            int rName = (int)(Math.random()*50);//50
            int rNationality = (int)(Math.random()*195);
            int rSurnameF = (int)(Math.random()*50);//50
            int rSurnameS = (int)(Math.random()*50);//50
            int rBlood = (int)(Math.random()*8);
            int a = (int)(Math.random()*2);
            if (a == 0){
                name = names.getNamesM();
                rheight = (Math.random()*35)+165;
                mCount++;
            }else if (a == 1){
                name = names.getNamesF();
                rheight = (Math.random()*20)+150;
                fCount++;
            }

            this.sex[i] = (a == 0)?("M"):(a == 1)?("F"):null;
            this.nationality[i] = nat[rNationality];
            this.weight[i] = (Math.random()*63)+37; //100-37
            this.age[i] = (int)(Math.random()*72)+18; //90-18
            this.height[i] = rheight / 100.0;
            this.person[i] = name[rName]+ " " +surname[rSurnameF]+ " " +surname[rSurnameS];
            this.blood[i] = bloodType[rBlood];

            natArray[i] = rNationality;
        }
    }

    public String[] getSex() {
        return sex;
    }

    public String[] getNationality() {
        return nationality;
    }

    public String[] getPerson() {
        return person;
    }

    public double[] getWeight() {
        return weight;
    }

    public int[] getAge() {
        return age;
    }

    public double[] getHeight() {
        return height;
    }

    public String[] getBlood() {
        return blood;
    }

    public int getmCount() {
        return mCount;
    }

    public int getfCount() {
        return fCount;
    }

    public double getmPercentaje(){
        return (mCount * 100.0) / (mCount + fCount);
    }

    public double getfPercentaje(){
        return (fCount * 100.0) / (mCount + fCount);
    }

    public double getPercentage(){
        this.poss = 0;
        this.times = 0;
        double percentage = 0;
        int count = 0;
        boolean major = true;
        int[] countAr = new int[this.natArray.length];
        for (int i = 0; i < natArray.length; i++){
            for (int j = 0; j < natArray.length; j++){
                if (natArray[i] == natArray[j]) count++;
            }
            countAr[i] = count;
            count = 0;
        }

        for (int i = 1; i < natArray.length; i++){
            //if (i + 1 == natArray.length) break;
            if (countAr[0] < countAr[i]) {
                for (int j = i + 1; j < natArray.length; j++){
                    //if (j + 1 == natArray.length) break;
                    if (countAr[i] < countAr[j]){
                        this.poss = j;
                        this.times = countAr[j];
                        major = false;
                    }else{
                        this.poss = i;
                        this.times = countAr[i];
                        major = false;
                    }
                }
            }
            break;
        }

        if (major){
            this.poss = 0;
            this.times = countAr[0];
        }

        percentage = (this.times * 100.0) / natArray.length;
        return percentage;
    }

    public String getCountry(){
        return this.nationality[this.poss];
    }

    public int getTimes(){
        return this.times;
    }

    public int PromAges(){
        double ages = 0;
        for (int i = 0; i < this.age.length; i++){
            ages += this.age[i];
        }
        return (int)Math.round(ages / this.age.length);
    }

    public double PromWeights(){
        double weights = 0;
        for (int i = 0; i < this.weight.length; i++){
            weights += this.weight[i];
        }
        return weights / this.weight.length;
    }

    public double PromHeight(){
        double heights = 0;
        for (int i = 0; i < this.height.length; i++){
            heights += this.height[i];
        }
        return heights / this.height.length;
    }

    public static double round(double a){
        return Math.round(a * 100.0)/100.0;
    }
}