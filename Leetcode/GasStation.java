/**
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * Note:
 * The solution is guaranteed to be unique.
 * 
 * Tags: Greedy
 */

class GasStation {
	/**
     * Use restGas to store the gas left for current trip
     * Use previous to store the gas needed for previous trips
     * Go through the list and calculate restGas
     * If restGas < 0, update previous, reset restGas, set start index from next
     * If previous + restGas >= 0, which means there is a solution, return start
     * Otherwie can't make the trip, return -1
     */
	public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null||cost==null||gas.length==0||cost.length==0||gas.length!=cost.length) return -1;
        int gasLen = gas.length;
        if(gasLen==1 && gas[0]>=cost[0]) return 0;
        
        int sum = 0;
        for(int i=0;i<gas.length;i++){
            sum+=gas[i];
            sum-=cost[i];
        }
        if(sum<0) return -1;
        
        int startIndex = 0;
        int prevCost = 0;
        int restCost = 0;
        for(int i =0;i<gas.length;i++){
            restCost+=gas[i]-cost[i];
            if(restCost<0){
                prevCost = restCost;
                restCost = 0;
                startIndex = i+1;
            }
        }
        return prevCost+restCost>=0?startIndex:-1;
    }
}
