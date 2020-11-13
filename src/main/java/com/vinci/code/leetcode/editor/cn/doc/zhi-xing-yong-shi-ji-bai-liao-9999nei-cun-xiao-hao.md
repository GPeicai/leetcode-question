### 解题思路
我这里互换使用了一个临时变量,内存消耗少了,但是代码的阅读性变差了.
![image.png](https://pic.leetcode-cn.com/1603885645-ySYDLi-image.png)

### 代码

```java
class Solution {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while(l < r) {
           s[l] = (char)(s[l] + s[r]);
           s[r] = (char)(s[l] - s[r]);
           s[l] = (char)(s[l] - s[r]);
           l++;
           r--;
        }

    }
}
```

如果使用临时变量的话
```
public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while(l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
```
