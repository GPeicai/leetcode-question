### 解题思路
344题反转数组的进阶版，每2k为一组，前k个元素反转，后k个元素保持不变。
前k个元素的下表为（i, i + k - 1）,此处需判断是否超出数组范围，反转之后 i = i +2k,
进行下一组的反转。


### 代码

```java
class Solution {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;
// 每2k个元素为一组进行反转
        for (int i = 0; i < n; i += 2 * k){
            int left = i;
            int right = (i + k - 1 < n) ? i + k -1 : n - 1; //判断下标是否越界
            while (left <= right){
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
        }
        String str = new String(ch);
        return str;

    }
   
}
```