package purple.lemon.repository

import org.springframework.jdbc.core.JdbcTemplate
import java.util.*
import javax.sql.DataSource

class EditorRepositoryImpl(
        dataSource: DataSource
) : EditorRepository {

    private val jdbcTemplate = JdbcTemplate(dataSource)

    override fun saveDataContent(request: EditorRepository.SaveDataRequest) {
        //TODO: Check if the entry is already in the database. Otherwise don't update but insert.
        val saveQuery = "UPDATE EditorContent SET EditorData = ? WHERE Id = ?"
        val updated = jdbcTemplate.update(
                saveQuery,
                request.content,
                request.id
        )
    }

    override fun getEditorData(request: EditorRepository.GetDateRequest): Optional<EditorRepository.EditorDataResponse> {
        TODO()
    }
}