package purple.lemon.repository

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import purple.lemon.infra.jdbc.EditorRepository
import purple.lemon.model.EditorData
import java.sql.ResultSet
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
                request.userId
        )
    }

    override fun getEditorData(request: EditorRepository.GetDataRequest): Optional<EditorRepository.EditorDataResponse> {
        val obtainQuery = "SELECT Id, EditorData FROM EditorContent WHERE Id = ?"

        val result = jdbcTemplate.query(obtainQuery, arrayOf(request.userId), rowMapperEditorData())[0]
        return Optional.of(EditorRepository.EditorDataResponse(result.id, result.data));
    }

    private fun rowMapperEditorData(): RowMapper<EditorData> {
        return RowMapper<EditorData> { rs: ResultSet, _: Int ->
            EditorData(
                    rs.getInt("Id"),
                    rs.getString("EditorData")
            )
        }
    }
}