package gfg.springframework.test.services.map;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import gfg.springframework.model.Author;
import gfg.springframework.services.map.AuthorMapService;

@DisplayName("Author Map Service Test - ")
class AuthorMapServiceTest {

	AuthorMapService authorMapService;

	@BeforeEach
	void setUp() {

		authorMapService = new AuthorMapService();

	}

	@DisplayName("Verifying that there are Zero Authors")
	@Test
	void authorsAreZero() {
		int authorCount = authorMapService.findAll().size();

		assertThat(authorCount).isZero();
	}

	@DisplayName("Saving Authors Tests - ")
	@Nested
	class SaveAuthorsTests {

		@BeforeEach
		void setUp() {
			authorMapService.save(new Author(1L, "Before", "Each"));
		}

		@DisplayName("Saving Author")
		@Test
		void saveAuthor() {
			Author author = new Author(2L, "Joe", "Tribbiani");

			Author savedAuthor = authorMapService.save(author);

			assertThat(savedAuthor).isNotNull();
		}

		@DisplayName("Save Authors Tests - ")
		@Nested
		class FindAuthorsTests {

			@DisplayName("Find Author")
			@Test
			void findAuthor() {

				Author foundAuthor = authorMapService.findById(1L);

				assertThat(foundAuthor).isNotNull();
			}

			@DisplayName("Find Author Not Found")
			@Test
			void findAuthorNotFound() {

				Author foundAuthor = authorMapService.findById(2L);

				assertThat(foundAuthor).isNull();
			}
		}
	}
	// }

	@DisplayName("Verify Still Zero Authors")
	@Test
	void authorsAreStillZero() {
		int authorCount = authorMapService.findAll().size();

		assertThat(authorCount).isZero();
	}
}