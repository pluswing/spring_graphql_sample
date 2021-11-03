import gql from 'graphql-tag'
import React from 'react'
import { useQuery } from 'urql'
import {PostComponent, Post} from './Post'

const POSTS_QUERY = gql`
  {
    posts {
      id
      author
      category
      title
      content
    }
  }
`

const PostList = () => {
  const [result] = useQuery({ query: POSTS_QUERY });
  const { data, fetching, error } = result

  if (fetching) return <div>Fetching</div>
  if (error) return <div>Error</div>

  const postsToRender: Post[] = data.posts
  return (
    <div>
      {postsToRender.map(post => <PostComponent key={post.id} post={post} />)}
    </div>
  )
}

export default PostList
