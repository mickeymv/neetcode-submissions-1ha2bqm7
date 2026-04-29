class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = defaultdict(int)
        for i in range(len(nums)): #counts freq of each number in nums
            freq[nums[i]] += 1

        #we need to order the freq counts 

        freq_num_tuples = []

        for num, fre in freq.items():
            freq_num_tuples.append((fre, num))

        sorted_freq_num_tuples = sorted(freq_num_tuples, reverse=True)

        top_k_frequent = []

        for i in range(k):
            top_k_frequent.append(sorted_freq_num_tuples[i][1])

        return top_k_frequent



        