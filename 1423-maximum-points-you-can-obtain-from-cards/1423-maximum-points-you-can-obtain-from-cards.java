class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int windowScore = 0;
        for(int i = 0; i < k; i++){
            windowScore += cardPoints[i];
        }

        int maxScore = windowScore;

        for(int i = 1; i <= k; i++){
            windowScore += cardPoints[cardPoints.length-i] - cardPoints[k-i];
            maxScore = Math.max(maxScore, windowScore);
        }
        return maxScore;
    }
}