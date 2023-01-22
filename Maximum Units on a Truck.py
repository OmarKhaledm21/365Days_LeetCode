
class Solution:
    def maximumUnits(self, boxTypes: List[List[int]], truckSize: int) -> int:
        boxTypes.sort(key=lambda x: -x[1])
        total = 0
        for box in boxTypes:
            if truckSize > 0:
                if box[0] <= truckSize:
                    truckSize -= box[0]
                    total += (box[0]*box[1])
                else:
                    total += (truckSize*box[1])
                    truckSize = 0
            else:
                break
        return total