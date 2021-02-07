package purple.lemon.model

data class EditorData(
        val id: Int,
        val data: String
) {
    companion object {
        fun emptyObject(): EditorData {
            return EditorData(0, "")
        }
    }
}