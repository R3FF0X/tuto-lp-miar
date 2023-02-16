package com.example.tuto5

class Todos {

    companion object {

        val COMPARATEUR = Comparator<Todo> { t0, t1 -> t0.compareTo(t1) }

        fun initTodolist(): ArrayList<Todo> {
            return ArrayList(
                mutableListOf<Todo>(
                    Todo("quis ut nam facilis et officia qui", false),
                    Todo("fugiat veniam minus", false),
                    Todo("et porro tempora", true),
                    Todo("laboriosam mollitia et enim quasi adipisci quia provident illum", false),
                    Todo(
                        "laudantium eius officia perferendis provident perspiciatis asperiores",
                        false
                    ),
                    Todo("nesciunt itaque commodi tempore", true),
                    Todo("omnis consequuntur cupiditate impedit itaque ipsam quo", false),
                    Todo("inventore saepe cumque et aut illum enim", true),
                    Todo("voluptates dignissimos sed doloribus animi quaerat aut", false),
                    Todo("explicabo odio est et", false),
                    Todo("consequuntur animi possimus", false),
                    Todo("culpa eius et voluptatem et", true),
                    Todo("accusamus sint iusto et voluptatem exercitationem", false),
                    Todo(
                        "temporibus atque distinctio omnis eius impedit tempore molestias pariatur",
                        false
                    ),
                    Todo("ut quas possimus exercitationem sint voluptates", false),
                    Todo("rerum debitis voluptatem qui eveniet tempora distinctio a", true),
                    Todo("rerum ex veniam mollitia voluptatibus pariatur", true),
                    Todo("dignissimos quo nobis earum saepe", true),
                    Todo("quis eius est sint explicabo", true),
                    Todo("numquam repellendus a magnam", true),
                    Todo("ipsam aperiam voluptates qui", false)
                )
            )
        }

    }
}