class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for(int w : weights){
            low = Math.max(low, w);
            high += w;
        }

        int result = high;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(canShipInDays(weights, days, mid)){
                result = mid;
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private boolean canShipInDays(int[] weights, int daysLimit, int cap){
        int daysNeeded = 1;
        int currentWeight = 0;

        for(int w: weights){
            if(currentWeight + w > cap){
                daysNeeded++;
                currentWeight = w;
            } else {
                currentWeight += w;
            }
        }
        return daysNeeded <= daysLimit;
    }
}