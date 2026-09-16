package com.jinsui.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Cream=Color(0xFFFFF9F0)
private val Green=Color(0xFF5E8063)
private val DarkGreen=Color(0xFF294733)
private val Orange=Color(0xFFE39A54)

class MainActivity:ComponentActivity(){
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        setContent{JinSuiApp()}
    }
}

@Composable
fun JinSuiApp(){
    var tab by remember{mutableStateOf(0)}
    MaterialTheme(colorScheme=lightColorScheme(primary=Green,background=Cream,surface=Cream)){
        Scaffold(
            containerColor=Cream,
            bottomBar={
                NavigationBar(containerColor=Color.White){
                    listOf("首页","账本","日历","日记").forEachIndexed{i,label->
                        NavigationBarItem(
                            selected=tab==i,
                            onClick={tab=i},
                            icon={Text(listOf("⌂","¥","日","记")[i])},
                            label={Text(label)}
                        )
                    }
                }
            }
        ){p->
            Box(Modifier.padding(p).fillMaxSize()){
                when(tab){
                    0->Home()
                    1->Page("账本","记录收入与支出")
                    2->Page("日历","查看每日生活轨迹")
                    else->Page("日记","记录心情与故事")
                }
            }
        }
    }
}

@Composable
fun Home(){
    Column(Modifier.fillMaxSize().padding(20.dp),verticalArrangement=Arrangement.spacedBy(14.dp)){
        Text("锦岁",fontSize=30.sp,fontWeight=FontWeight.Bold,color=DarkGreen)
        Text("2026年9月16日  ·  星期三",color=Color.Gray)
        Text("锦绣岁月，日日有余。",color=Green)
        Card(colors=CardDefaults.cardColors(Color.White),shape=RoundedCornerShape(20.dp)){
            Column(Modifier.padding(20.dp),verticalArrangement=Arrangement.spacedBy(10.dp)){
                Text("今日收支",fontWeight=FontWeight.Bold,color=DarkGreen)
                Row(Modifier.fillMaxWidth(),horizontalArrangement=Arrangement.SpaceBetween){
                    Text("收入\n¥0",color=Green)
                    Text("支出\n¥0",color=Orange)
                    Text("结余\n¥0",color=DarkGreen)
                }
            }
        }
        Row(Modifier.fillMaxWidth(),horizontalArrangement=Arrangement.spacedBy(10.dp)){
            Button(onClick={},Modifier.weight(1f)){Text("记一笔")}
            OutlinedButton(onClick={},Modifier.weight(1f)){Text("写日记")}
        }
        Card(colors=CardDefaults.cardColors(Color(0xFFF0F5EE)),shape=RoundedCornerShape(20.dp)){
            Column(Modifier.padding(18.dp),verticalArrangement=Arrangement.spacedBy(6.dp)){
                Text("今日卦象",fontWeight=FontWeight.Bold,color=DarkGreen)
                Text("乾为天 · Qián",fontSize=20.sp,fontWeight=FontWeight.Bold)
                Text("第一卦  ☰☰",color=Green)
                Text("刚健、主动、持续行动。")
                Text("工作：明确目标并推进\n人际：保持坦诚\n财运：重视长期积累")
                OutlinedButton(onClick={}){Text("换一卦")}
            }
        }
        Text("※ 宜忌与卦象仅作为传统文化与自我记录参考，不代表科学预测。",color=Color.Gray,fontSize=12.sp)
    }
}

@Composable
fun Page(title:String,subtitle:String){
    Column(Modifier.fillMaxSize().padding(24.dp),verticalArrangement=Arrangement.spacedBy(12.dp)){
        Text(title,fontSize=28.sp,fontWeight=FontWeight.Bold,color=DarkGreen)
        Text(subtitle,color=Color.Gray)
        Button(onClick={}){Text("开始记录")}
    }
}
