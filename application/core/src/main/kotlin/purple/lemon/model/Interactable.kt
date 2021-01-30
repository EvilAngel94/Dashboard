package purple.lemon.model

data class Interactable(
        private val id: Int,
        private val redirectionUrl: String,
        private val placeholderSrc: String,
        private val src: String,
        private val slug: String,
        private val gif: String,
        private val title: String
)
