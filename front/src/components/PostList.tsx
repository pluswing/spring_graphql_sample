import React from 'react'
import { usePostsQuery } from '../generated/graphql'
import { Link } from 'react-router-dom'

const PostList = () => {
  const [result] = usePostsQuery();
  const { data, fetching, error } = result

  if (fetching) return <div>Fetching</div>
  if (error) return <div>Error</div>

  const postsToRender = data!.posts
  return (
    <div>
      {postsToRender.map(post => (
      <div>
        <div>
          {post.title} ({post.category})
          <Link to={`/posts/${post.id}`} className="ml1 no-underline black">
            detail
          </Link>
        </div>
      </div>
      ))}
    </div>
  )
}

export default PostList
