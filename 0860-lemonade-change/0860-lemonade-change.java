class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int five = 0,
            ten = 0;

        for(int i = 0; i < n ; i++){
            int money = bills[i];
            if(money == 5){
                five++;
            } else if(money == 10){
                ten++;
                if(five==0){
                    return false;
                }
                five--;
            } else if(money == 20){
                if(five>0 && ten>0){
                    ten--;
                    five--;
                } else if(five >= 3){
                    five -=3;
                } else {
                    return false;
                }
            } else {
                if(five<3){
                    return false;
                }
                five -=3;
            }
        }    
        return true;
    }
}