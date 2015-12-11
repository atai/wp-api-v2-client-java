package com.afrozaar.wordpress.wpapi.v2;

import static org.assertj.core.api.Assertions.assertThat;

import com.afrozaar.wordpress.wpapi.v2.model.Post;
import com.afrozaar.wordpress.wpapi.v2.response.PagedResponse;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author johan
 */
public class PagedResponseTest {

    @Test
    public void pagedResponseTest() {
        List<Post> posts = Arrays.asList();

        PagedResponse<Post> postResponse = PagedResponse.Builder.aPagedResponse(Post.class)
                .withSelf("http://example.com/self")
                .withNext(Optional.of("http://example.com/self?page=1"))
                .withPosts(posts)
                .build();

        assertThat(postResponse.getPrevious().isPresent()).isFalse();
        assertThat(postResponse.getNext().isPresent()).isTrue();
        assertThat(postResponse.getList()).isEmpty();

    }

}