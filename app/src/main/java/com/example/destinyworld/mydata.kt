package com.example.destinyworld

import android.provider.ContactsContract

data class guide(val title:String, val desc:String, val image:Int)
data class planets(val image:Int, val title:String, val text:String)

data class login(val id:String,
                 val email:String,
                 val nickName: String,
                 val avatar:String,
                 val token:String)




object List {
    val list = arrayListOf(
        guide("Узнайте лор игры!","Появившийся в Солнечной системе Странник дал человечеству возможность бороться за право существовать. С силой самого Света на их стороне, люди смогли войти в свой Золотой Век.\n",
        R.drawable.frame1),
        guide("Экзотические оружия!",
        "Узнайте историю и характеристики каждого экзотика мира Destiny 2 а так же изучите способы их получения!\n",
        R.drawable.frame2),
        guide("Дерзай, Страж!",
        "Получите ценнейший опыт благодаря новой информации и прорывайся к новым рубежам, все в твои руках!\n",
        R.drawable.frame3)
    )
}

object ListOfPlanets {
    val ListOfPlanets = arrayListOf(
        planets(R.drawable.planet,"Сатурн", "Прекрасная планета"),
        planets(R.drawable.planet,"Венера", "Прекрасная планета"),
        planets(R.drawable.planet,"Юпитер", "Прекрасная планета"),
        planets(R.drawable.planet,"Ио", "Прекрасная планета"),
    )
}