<?php

class Solution
{

    /**
     * @param String[] $words
     * @return Integer
     */
    public function maximumNumberOfStringPairs($words)
    {
        $res = 0;
        $map = array();
        foreach ($words as $word) {
            $map[$word] = false;
        }
        foreach ($words as $word) {
            if (!$map[$word]) {
                $map[$word] = true;
                $word_rev = strrev($word);
                if (isset($map[$word_rev]) && (!$map[$word_rev])) {
                    $map[$word_rev] = true;
                    $res++;
                } else {
                    $map[$word] = false;
                }
            }
        }
        return $res;
    }
}
