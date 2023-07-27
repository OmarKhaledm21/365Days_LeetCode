<?php
class Solution
{
    function heapify(&$arr, $N, $i)
    {
        $largest = $i; // Initialize largest as root
        $l = 2 * $i + 1; // left = 2*i + 1
        $r = 2 * $i + 2; // right = 2*i + 2

        // If left child is larger than root
        if ($l < $N && $arr[$l] > $arr[$largest])
            $largest = $l;

        // If right child is larger than largest so far
        if ($r < $N && $arr[$r] > $arr[$largest])
            $largest = $r;

        // If largest is not root
        if ($largest != $i) {
            $swap = $arr[$i];
            $arr[$i] = $arr[$largest];
            $arr[$largest] = $swap;

            // Recursively heapify the affected sub-tree
            $this->heapify($arr, $N, $largest);
        }
    }

    function buildHeap(&$arr, $N)
    {
        // Build heap (rearrange array)
        $startIdx = floor(($N / 2)) - 1;
        for ($i = $startIdx; $i >= 0; $i--)
            $this->heapify($arr, $N, $i);
    }


    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function maxProduct($nums)
    {
        $sec = $nums[1];
        if (count($nums) > 2) {
            $this->buildHeap($nums, count($nums));
            $sec = max($nums[1], $nums[2]);
        }
        return (((int)$nums[0] - 1) * ((int)$sec - 1));
    }
}

$sol = new Solution();
echo $sol->maxProduct([10, 2, 5, 2]);
