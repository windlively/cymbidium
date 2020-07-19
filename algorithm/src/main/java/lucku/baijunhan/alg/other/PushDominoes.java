package lucku.baijunhan.alg.other;

/**
 * 838. 推多米诺
 * 一行中有 N 张多米诺骨牌，我们将每张多米诺骨牌垂直竖立。
 *
 * 在开始时，我们同时把一些多米诺骨牌向左或向右推。
 *
 *
 *
 * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。
 *
 * 同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
 *
 * 如果同时有多米诺骨牌落在一张垂直竖立的多米诺骨牌的两边，由于受力平衡， 该骨牌仍然保持不变。
 *
 * 就这个问题而言，我们会认为正在下降的多米诺骨牌不会对其它正在下降或已经下降的多米诺骨牌施加额外的力。
 *
 * 给定表示初始状态的字符串 "S" 。如果第 i 张多米诺骨牌被推向左边，则 S[i] = 'L'；如果第 i 张多米诺骨牌被推向右边，则 S[i] = 'R'；如果第 i 张多米诺骨牌没有被推动，则 S[i] = '.'。
 *
 * 返回表示最终状态的字符串。
 *
 * 示例 1：
 *
 * 输入：".L.R...LR..L.."
 * 输出："LL.RR.LLRRLL.."
 * 示例 2：
 *
 * 输入："RR.L"
 * 输出："RR.L"
 * 说明：第一张多米诺骨牌没有给第二张施加额外的力。
 * 提示：
 *
 * 0 <= N <= 10^5
 * 表示多米诺骨牌状态的字符串只含有 'L'，'R'; 以及 '.';
 */
public class PushDominoes {

    public static void main(String[] args) {
        System.out.println(new Solution().pushDominoes(".L.R...LR..L.."));
    }

    static class Solution {
        public String pushDominoes(String dominoes) {
            char[] cs = dominoes.toCharArray();
            for(int i = 0;i < cs.length; ){
                while(i < cs.length && cs[i] == '.') i++;
                if(i == cs.length) break;
                if(cs[i] == 'L'){
                    for(int j = i - 1; j >= 0 && cs[j] == '.'; j--) cs[j] = 'L';
                    i ++;
                }else if(cs[i] == 'R'){
                    int j;
                    for(j = i + 1; j < cs.length && cs[j] == '.'; j ++);
                    if(j == cs.length || cs[j] == 'R'){
                        for(int k = i + 1; k < cs.length && k <= j; k++) cs[k] = 'R';
                        i = j;
                    }else if(j - i > 1){
                        for(int m = i + 1, n = j - 1; m <= n; m ++, n--){
                            if(m == n) {
                                cs[m] = '.';
                                break;
                            }
                            cs[m] = 'R';
                            cs[n] = 'L';
                        }
                        i = j + 1;
                    }else{
                        i = j;
                    }

                }


            }
            return new String(cs);
        }
    }

}

