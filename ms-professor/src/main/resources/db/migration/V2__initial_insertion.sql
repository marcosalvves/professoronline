-- ==============================
-- V2 INSERÇÃO DE DADOS CORRIGIDA PARA MS-PROFESSOR
-- ==============================

-- 1. Tipos de usuário
INSERT INTO tipo_usuario (nome) VALUES ('ADMIN'), ('PROFESSOR');

-- 2. Usuários (senha '123456' com BCrypt)
-- Senha de todos os usuários é '123456' encodificada.
INSERT INTO usuario (nome, email, senha, status) VALUES
('Admin do Sistema', 'admin@sistema.com', '$2a$10$tJ08dYgJqH6xQ/L3gR7r8.b2WfH7gB.K4gUf4kQ0n1', true), -- ID 1
('Professor A', 'prof_a@escola.com', '$2a$10$tJ08dYgJqH6xQ/L3gR7r8.b2WfH7gB.K4gUf4kQ0n1', true), -- ID 2
('Professor B', 'prof_b@escola.com', '$2a$10$tJ08dYgJqH6xQ/L3gR7r8.b2WfH7gB.K4gUf4kQ0n1', true), -- ID 3
('Professor C', 'prof_c@escola.com', '$2a$10$tJ08dYgJqH6xQ/L3gR7r8.b2WfH7gB.K4gUf4kQ0n1', true); -- ID 4

-- 3. Vínculo tipo_usuario
INSERT INTO usuario_tipousuario (id_usuario, id_tipousuario) VALUES
(1, 1),
(2, 2),
(3, 2),
(4, 2);

-- 4. Escolas (Minimalista - ID 1)
INSERT INTO escola (nome, status, criacao_date) VALUES
('Escola de Ciências Tecnológicas', true, '2025-01-01');

-- 5. Professores
INSERT INTO professor (id_usuario, id_escola, registro_professor, status_professor) VALUES
(2, 1, 'TEC-2025-001', true), -- ID 1
(3, 1, 'TEC-2025-002', true), -- ID 2
(4, 1, 'TEC-2025-003', true); -- ID 3

-- 6. Categorias de formação
INSERT INTO tipo_categoria (nome_categoria) VALUES
('Graduação'), ('Especialização'), ('Mestrado'), ('Doutorado');

-- 7. Formação acadêmica (vinculada aos IDs de Professor 1, 2 e 3)
INSERT INTO formacao_academica (id_professor, id_tipo_categoria, nome_curso, nome_instituicao_formacao, ano_conclusao) VALUES
(1, 3, 'Engenharia de Software', 'USP', 2018),
(2, 4, 'Ciência da Computação', 'UNICAMP', 2022),
(3, 2, 'Lógica e Programação', 'UCSAL', 2015);