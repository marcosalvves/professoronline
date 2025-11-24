package code_miners.auth_service.auth_ms.Core.Application.Mapper;

public interface IMapper<TResponse, TRequest, TEntity> {
    TResponse toDto(TEntity entity);
    TEntity toEntity(TRequest request);
}
