package application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfig {

    private final DataSource dataSource;

    @Autowired
    public ApplicationConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    EditorRepository editorRepository() {
        return new JdbcEditorRepository(dataSource);
    }

}
