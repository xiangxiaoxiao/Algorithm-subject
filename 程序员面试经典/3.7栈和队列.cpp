/*题目描述

        有家动物收容所只收留猫和狗，但有特殊的收养规则，收养人有两种收养方式，第一种为直接收养所有动物中最早进入收容所的，第二种为选择收养的动物类型（猫或狗），并收养该种动物中最早进入收容所的。
       给定一个操作序列int[][2] ope(C++中为vector<vector<int>>)代表所有事件。若第一个元素为1，则代表有动物进入收容所，第二个元素为动物的编号，正数代表狗，负数代表猫；若第一个元素为2，则代表有人收养动物，第二个元素若为0，则采取第一种收养方式，若为1，则指定收养狗，若为-1则指定收养猫。请按顺序返回收养的序列。若出现不合法的操作，即没有可以符合领养要求的动物，则将这次领养操作忽略。
测试样例：
[[1,1],[1,-1],[2,0],[2,-1]]
返回：[1,-1]
*/
class CatDogAsylum {
public:
    vector<int> asylum(vector<vector<int> > ope) {
        // write code here
        vector<int> outAnimals;   //领养序列
        list<int> inAnimals;     //收容所现有的动物
        int siz = ope.size();
        for(int i = 0; i < siz; i++){
            if(ope[i][0] == 1){     //收容动物
                inAnimals.push_back(ope[i][1]);
            }
            else{       //领养动物
                if(inAnimals.empty()) continue;
                else{
                    if(ope[i][1] == 0) {
                        outAnimals.push_back(inAnimals.front());
                        inAnimals.pop_front();
                    }
                    else if(ope[i][1] == 1){
                        auto it = inAnimals.begin();
                        while(it != inAnimals.end()){
                            if(*it > 0){
                                outAnimals.push_back(*it);
                                inAnimals.erase(it);
                                break;
                            }
                            it++;
                        }
                        continue;
                    }
                    else{
                        auto it = inAnimals.begin();
                        while(it != inAnimals.end()){
                            if(*it < 0){
                                outAnimals.push_back(*it);
                                inAnimals.erase(it);
                                break;
                            }
                            it++;
                        }
                        continue;
                    }
                }
            }
        }
        return outAnimals;
    }
};