package EvaluacionFinal.DAWI_Pillco_Porlles_David.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HikariCpConfig {

    @Value("${DB_FABRIC_URL}")
    private String dbFabricUrl;
    @Value("${DB_FABRIC_USER}")
    private String dbFabricUser;
    @Value("${DB_FABRIC_PASS}")
    private String dbFabricPass;
    @Value("${DB_FABRIC_DRIVER}")
    private String dbFabricDriver;

    @Bean
    public HikariDataSource hikariDataSource() {

        HikariConfig config = new HikariConfig();

        /**
         * Configurar propiedad de conexión a la base de datos "fabric".
         */
        config.setJdbcUrl(dbFabricUrl);
        config.setUsername(dbFabricUser);
        config.setPassword(dbFabricPass);
        config.setDriverClassName(dbFabricDriver);

        /**
         * Configurar propiedades del pool de HikariCP:
         * - MaximumPoolSize: Máximo número de conexiones en el pool.
         * - MinimumIdle: Mínimo número de conexiones inactivas en el pool.
         * - IdleTimeout: Tiempo máximo para eliminar una conexión inactiva.
         * - ConnectionTimeout: Tiempo máximo de espera para obtener una conexión.
         */
        config.setMaximumPoolSize(20);
        config.setMinimumIdle(5);
        config.setIdleTimeout(300000); // 5 minutos
        config.setConnectionTimeout(30000); // 30 segundos

        System.out.println("###### HikariCP initialized ######");
        return new HikariDataSource(config);
    }
}