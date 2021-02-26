FROM postgres:13.2
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD postgres
ENV POSTGRES_DB dashboard-db-dev
COPY pg-init.sql/ /docker-entrypoint-initdb.d/