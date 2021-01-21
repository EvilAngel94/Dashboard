package purple.lemon.dashboard.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import purple.lemon.dashboard.model.EditorData;

import javax.sql.DataSource;
import java.util.Optional;

public class JdbcEditorRepository implements EditorRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcEditorRepository(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public void saveDataContent(int id, String content) {
        //TODO: Check if the entry is already in the database. Otherwise don't update but insert.
        String saveQuery = "UPDATE EditorContent SET EditorData = ? WHERE Id = ?";
        int updated = jdbcTemplate.update(saveQuery, content, id);
    }

    @Override
    public Optional<EditorData> getEditorData(int id) {
        final String obtainQuery = "SELECT Id, EditorData FROM EditorContent WHERE Id = ?";

        return Optional.of(
                jdbcTemplate.query(obtainQuery, new Object[]{id}, (rs, rowNum) -> new EditorData(
                                rs.getInt("Id"),
                                rs.getString("EditorData")
                        )
                ).get(0));
    }

}
