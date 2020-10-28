package com.uu.leecode.n3;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 4495 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     *  最大值为：preMaxLength ,或者 currentStr：当前正在添加的字符串；
     *
     * i 为左指针，j为右指针
     *      遍历过程中：
     *      1） 存在重复元素:
     *             更新最大长度值：  最大长度值 = (j - j),preMaxLength 的最大值
     *             移动i 指针为 currentStr中重复字符的角标；
     *      2)  不存在重复元素：
     *              currentStr += 当前遍历chart
     *
     *
     */
    public static int lengthOfLongestSubstring(String s) {

        int i = 0,j = 0;
        String currentStr = "";
        int preMaxLength = 0;

        for (; j < s.length(); j++) {
            Character val = s.charAt(j);
            if(currentStr == null){
                currentStr = val.toString();
                preMaxLength = 1;
                continue;
            }
            // 重复元素角标
            int temp = currentStr.indexOf(val);
            if(temp >= 0){ // 有重复的
                preMaxLength = Math.max(j - i ,preMaxLength);

                i = i + temp +1;
                currentStr = s.substring(i,j +1  );
              //  System.out.println(currentStr);
            }else{
                currentStr += val.toString();
            }
        }

        return Math.max(currentStr.length(),preMaxLength);
    }

    public static int lengthOfLongestSubstringV2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;//用于记录最大不重复子串的长度
        int left = 0;//滑动窗口左指针
        for (int i = 0; i < s.length() ; i++)
        {
            /**
             1、首先，判断当前字符是否包含在map中，如果不包含，将该字符添加到map（字符，字符在数组下标）,
             此时没有出现重复的字符，左指针不需要变化。此时不重复子串的长度为：i-left+1，与原来的maxLen比较，取最大值；

             2、如果当前字符 ch 包含在 map中，此时有2类情况：
             1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
             那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
             2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
             而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
             随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
             应该不变，left始终为2，子段变成 ba才对。

             为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
             另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
             因此此时新的 s.charAt(i) 已经进入到 当前最长的子段中！
             */
            if(map.containsKey(s.charAt(i)))
            {
                left = Math.max(left , map.get(s.charAt(i))+1);
            }
            //不管是否更新left，都要更新 s.charAt(i) 的位置！
            map.put(s.charAt(i) , i);
            maxLen = Math.max(maxLen , i-left+1);
        }

        return maxLen;
    }


    
    public static void main(String[] args) {
         System.out.println(lengthOfLongestSubstringV2("abba"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
